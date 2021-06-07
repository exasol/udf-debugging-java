import os

import requests
import sys
import time
from watchdog.events import FileSystemEventHandler
from watchdog.observers import Observer


class Watcher:
    DIRECTORY_TO_WATCH = "/tmp/"

    def __init__(self):
        self.observer = Observer()

    def run(self):
        event_handler = Handler()
        self.observer.schedule(event_handler, self.DIRECTORY_TO_WATCH, recursive=True)
        self.observer.start()
        try:
            while True:
                time.sleep(5)
        except:
            self.observer.stop()
            print("Error")

        self.observer.join()


known_files = dict()

counter = 0


class Handler(FileSystemEventHandler):

    @staticmethod
    def on_any_event(event):
        if event.src_path.endswith(".hpl") and event.src_path.startswith("/tmp/exa"):
            if event.event_type == "created":
                if event.src_path in known_files:
                    return
                print("creating hard link for " + event.src_path)
                hard_link_name = '/tmp/profile' + str(time.time()) + "-" + str(len(known_files)) + ".hpl"
                os.link(event.src_path, hard_link_name)
                known_files[event.src_path] = hard_link_name
            elif event.event_type == "deleted" and event.src_path in known_files:
                print("transmitting deleted " + event.src_path)
                headers = {'Content-type': 'raw/binary', 'Slug': event.src_path}
                hardlink = known_files[event.src_path]
                requests.put("http://" + sys.argv[1] + "/pushProfile", data=open(hardlink, 'rb'),
                             headers=headers,
                             auth=('username', 'pass'))
                os.unlink(hardlink)


if __name__ == '__main__':
    w = Watcher()
    w.run()
